package cn.liusiqian.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.liusiqian.greendaodemo.db.Chat;
import cn.liusiqian.greendaodemo.db.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user1 = new User("1022","thomas",true,"13011112222");
        User user2 = new User("1021","mary",false,"13022223333");
        DaoManager.getInstance().getUserDao().insertOrReplace(user1);
        DaoManager.getInstance().getUserDao().insertOrReplace(user2);

        Chat chat = new Chat("msg123dd3f","1021","1022","Hello",System.currentTimeMillis());
        DaoManager.getInstance().getChatDao().insertOrReplace(chat);
    }
}
