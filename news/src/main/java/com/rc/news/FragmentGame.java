package com.rc.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.news.adapter.GameAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class FragmentGame extends Fragment {

    private GameAdapter mAdapter;
    private List<GameSerializable>gamedata;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_game_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        gamedata= new ArrayList<>();

        String[][] fs={{"总得分排行榜"},{"卡里姆-贾巴尔","38387"},{"卡尔-马龙","36928"},{"科比-布莱恩特","32748"},{"迈克尔-乔丹","32292"},{"威尔特-张伯伦","31419"},{"德克-诺维茨基","28609"}};
        String[][] lb={{"总篮板排行榜"},{"威尔特-张伯伦","23924"},{"比尔-拉塞尔","21620"},{"卡里姆-贾巴尔","17440"},{"埃尔文-海耶斯","16279"},{"摩西-马龙","16212"},{"卡尔-马龙","14967"}};
        String[][] zg={{"总助攻排行榜"},{"约翰-斯托克顿","15806"},{"贾森-基德","12091"},{"史蒂夫-纳什","10335"},{"马克-杰克逊","10334"},{"埃尔文-约翰逊","10141"},{"奥斯卡-罗伯森特","9887"}};
        String[][] qd={{"总抢断排行榜"},{"约翰-斯托克顿","3265"},{"贾森-基德","2684"},{"迈克尔-乔丹","2514"},{"加里-佩顿","2445"},{"莫里斯-奇克斯","2310"},{"斯科蒂-皮蓬","2307"}};
        String[][] gm={{"总盖帽排行榜"},{"哈基姆-奥拉朱旺 ","3830"},{"迪坎贝-穆托姆博","3289"},{"卡里姆-贾巴尔","3189"},{"马克-伊顿","3064"},{"蒂姆-邓肯","2977"},{"大卫-罗宾逊","2954"}};
        String[][] p3={{"总三分排行榜"},{"雷-阿伦","2973"},{"雷吉-米勒","2560"},{"贾森-特里","2097"},{"保罗-皮尔斯","2068"},{"贾森-基德","1988"},{"文斯-卡特","1885"}};

        gamedata.add(new GameSerializable(fs));
        gamedata.add(new GameSerializable(lb));
        gamedata.add(new GameSerializable(zg));
        gamedata.add(new GameSerializable(qd));
        gamedata.add(new GameSerializable(gm));
        gamedata.add(new GameSerializable(p3));

        mAdapter = new GameAdapter(gamedata);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }
    public class GameSerializable implements Serializable {

        private String[][] data;

        public GameSerializable(String[][] data){
            this.data=data;
        }
        public String[][] getData() {
            return data;
        }
        public void setData(String[][] data){
            this.data=data;
        }
    }
}