package jp.ac.anan_nct.smaoni_elide.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import jp.ac.anan_nct.smaoni_elide.R;
import jp.ac.anan_nct.smaoni_elide.model.GameData;
import jp.ac.anan_nct.smaoni_elide.model.Player;
import jp.ac.anan_nct.smaoni_elide.model.Position;
import jp.ac.anan_nct.smaoni_elide.model.Status;
import jp.ac.anan_nct.smaoni_elide.view.MemberView;

public class ReceptionActivity extends ActionBarActivity {

    LinearLayout linearLayout;
    MemberView[] memberViews;
    final int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    final int MP = LinearLayout.LayoutParams.MATCH_PARENT;

    Button gotoGame, addMember;

    public static GameData gameData;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);

        gameData = SelectActivity.gameData;
        linearLayout = (LinearLayout) findViewById(R.id.linear1);
        memberViews = new MemberView[gameData.getPlayerNum()];

        memberViews[0] = new MemberView(this, null);
        gameData.resetPlayer(0, new Player(3, "aさん", new Position(0,0), Status.RUNNER));
        memberViews[0].setInfo(0, gameData.getPlayer(0));
        linearLayout.addView(memberViews[0], new LinearLayout.LayoutParams(WC, WC));
        i = 1;

        gotoGame = (Button) findViewById(R.id.button6);
        addMember = (Button) findViewById(R.id.button7);

        setAction();

    }

    void setAction(){
        for(int i = 0; i < memberViews.length; i++){
            final int j = i;
         /*   memberViews[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });*/
        }
        gotoGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i != memberViews.length){
                    /*Player[] players = new Player[i];
                    for(int j = 0; j < i; j++){
                        players[j] = gameData.getPlayer(j);
                    }
                    gameData.setPlayerNum(i);*/
                }else {
                    startActivity(new Intent(ReceptionActivity.this, OniGokkoActivity.class));
                }
            }
        });
        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i < gameData.getPlayerNum()) {
                    Player p = new Player();
                    gameData.resetPlayer(i, p);
                    memberViews[i] = new MemberView(ReceptionActivity.this, null);
                    memberViews[i].setInfo(i, p);
                    linearLayout.addView(memberViews[i]);
                    i++;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reception, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}