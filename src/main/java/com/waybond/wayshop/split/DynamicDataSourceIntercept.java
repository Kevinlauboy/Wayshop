package com.waybond.wayshop.split;

import java.util.Locale;
import java.util.Properties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Intercepts({
    @Signature(type=Executor.class,method="update",args={MappedStatement.class,Object.class}),
    @Signature(type=Executor.class,method="query",args={MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})
})
public class DynamicDataSourceIntercept implements Interceptor {
	private Logger logger = LoggerFactory.getLogger(DynamicDataSourceIntercept.class);
	private static final String REGEX = ".*insert\\u0020.*|.*insert\\\\u0020.*|.*insert\\\\u0020.*|.*insert\\\\u0020.*";
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		logger.debug("####################asdasasd############################");
		boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();
		String lookupKey=DynamicDataSourceHolder.DB_MASTER;
		Object[] objects = invocation.getArgs();
		MappedStatement ms = (MappedStatement) objects[0];
		if (synchronizationActive != true) {
			// 读方法
			if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {

				if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
					lookupKey = DynamicDataSourceHolder.DB_MASTER;
				} else {
					BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
					String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n]", " ");
					if (sql.matches(REGEX)) {
						lookupKey = DynamicDataSourceHolder.DB_MASTER;
					} else {
						lookupKey = DynamicDataSourceHolder.DB_SLAVE;
					}
				}
			} else {
				lookupKey = DynamicDataSourceHolder.DB_MASTER;
			}
		}
		logger.debug("设置方法[{}] user [{}] Strategy,SqlCommanType [{}]..",ms.getId(),lookupKey,ms.getSqlCommandType()
				,ms.getSqlCommandType().name());
		DynamicDataSourceHolder.setDbType(lookupKey);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
