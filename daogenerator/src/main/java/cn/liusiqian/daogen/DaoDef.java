package cn.liusiqian.daogen;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class DaoDef
{
    private static final int DATABASE_VERSION = 2;

    public static void main(String[] args){
        Schema schema = new Schema(DATABASE_VERSION,"cn.liusiqian.greendaodemo.db");

        Entity userEntity = schema.addEntity("User");
        userEntity.addStringProperty("id").primaryKey();
        userEntity.addStringProperty("name");
        userEntity.addBooleanProperty("ismale");
        userEntity.addStringProperty("tel");

        Entity chatEntity = schema.addEntity("Chat");
        chatEntity.addStringProperty("msgid").primaryKey();
        chatEntity.addStringProperty("from");
        chatEntity.addStringProperty("to");
        chatEntity.addStringProperty("message");
        chatEntity.addLongProperty("timestamp");

        try
        {
            new DaoGenerator().generateAll(schema,"../demo/src/main/java");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
