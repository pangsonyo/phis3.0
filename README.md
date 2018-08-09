# phis3.0
@DynamicInsert属性:设置为true,设置为true,表示insert对象的时候,生成动态的insert语句,如果这个字段的值是null就不会加入到insert语句当中.默认false。
比如希望数据库插入日期或时间戳字段时，在对象字段为空的情况下，表字段能自动填写当前的sysdate。

@DynamicUpdate属性:设置为true,设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中,默认false。
