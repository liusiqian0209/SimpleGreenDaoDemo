package cn.liusiqian.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import cn.liusiqian.greendaodemo.db.ChatDao;
import cn.liusiqian.greendaodemo.db.DaoMaster;
import cn.liusiqian.greendaodemo.db.DaoSession;
import cn.liusiqian.greendaodemo.db.UserDao;

/**
 * Créé par liusiqian 17/9/22.
 */

public class DaoManager
{
    private static DaoManager instance;

    public static DaoManager getInstance()
    {
        if (instance == null)
        {
            synchronized (DaoManager.class)
            {
                if (instance == null)
                {
                    instance = new DaoManager();
                }
            }
        }
        return instance;
    }

    private SQLiteDatabase db;
    private DaoMaster master;
    private DaoSession session;
    private UserDao userDao;
    private ChatDao chatDao;

    private DaoManager()
    {
        db = new DaoMaster.DevOpenHelper(GreenDaoApplication.getInstance(), "database.db").getWritableDatabase();
        master = new DaoMaster(db);
        session = master.newSession();
        userDao = session.getUserDao();
        chatDao = session.getChatDao();
    }

    public UserDao getUserDao(){
        return userDao;
    }

    public ChatDao getChatDao(){
        return chatDao;
    }
}
