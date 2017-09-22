package cn.liusiqian.daogen;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class DaoDef
{
    private static final int DATABASE_VERSION = 1;

    public static void main(String[] args){
        Schema schema = new Schema(DATABASE_VERSION,"cn.liusiqian.greendaodemo.db");

        Entity userEntity = schema.addEntity("User");
        userEntity.addIdProperty();
        userEntity.addIntProperty("work_id");
        userEntity.addStringProperty("name");
        userEntity.addBooleanProperty("ismale");
        userEntity.addStringProperty("tel");

        Entity chatEntity = schema.addEntity("Chat");
        chatEntity.addIdProperty();
        chatEntity.addIntProperty("from");
        chatEntity.addIntProperty("to");
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
