package com.totoro_fly.journey;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShanghaiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShanghaiFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.scenery_listview)
    ListView sceneryListview;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ShanghaiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShanghaiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShanghaiFragment newInstance(String param1, String param2) {
        ShanghaiFragment fragment = new ShanghaiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.scenery_listview, container, false);
        ButterKnife.bind(this, view);
        final ArrayList<Scenery> shanghaiScenery = new ArrayList<Scenery>();
        shanghaiScenery.add(new Scenery(R.raw.dishini,R.drawable.dishini, "迪士尼", "上海迪士尼度假区位于中华人民共和国上海市浦东新区川沙新镇，首期占地390公顷，正在建设包括一座占地91公顷的上海迪士尼乐园和两个乐园、两间共提供1,220间房间的主题酒店、占地4.6万平方呎的零售餐饮娱乐区、占地40公顷的星愿湖及停车场等配套设施。上海迪士尼度假区是世界第6座、中国第2座迪士尼乐园度假区。"));
        shanghaiScenery.add(new Scenery(R.raw.jinmaodasha,R.drawable.jinmaodasha, "金茂大厦", "金茂大厦又称金茂大楼，位于中华人民共和国上海市浦东新区黄浦江畔的陆家嘴金融贸易区，楼高420.5米，目前是上海第3高的摩天大楼、中国大陆第10高楼（截至2015年）。大厦于1994年开工，1998年建成，有地上88层，若再加上尖塔的楼层共有93层，地下3层，楼面面积27万8,707平方米，有多达130部电梯与555间客房，现已成为上海的一座地标，是集现代化办公楼、五星级酒店、会展中心、娱乐、商场等设施于一体，融汇中国塔型风格与西方建筑技术的多功能型摩天大楼，由著名的美国芝加哥SOM设计事务所的前任设计合伙人Adrian Smith所设计。金茂大厦由金茂集团拥有。该楼日常维护费用为每日100万人民币。"));
        shanghaiScenery.add(new Scenery(R.raw.nanjinglu,R.drawable.nanjinglu, "南京路", "南京路（上海话拼音：nhoejinlhu，发音：[nø̀tɕi̋nlu᷆]），是位于中国上海市的一条世界知名的商业街。狭义的南京路即1945年以前的南京路，专指今天的南京东路。广义的南京路则包括南京东路和南京西路。"));
        shanghaiScenery.add(new Scenery(R.raw.waitan,R.drawable.waitan, "外滩", "外滩是上海市中心的一个区域，由一段沿黄浦江的马路和沿路的建筑和设施构成，为上海重要的地标之一。全长1.5公里，南起延安东路，北至苏州河上的外白渡桥，东面即黄浦江，西面是旧上海金融、外贸机构的集中地。"));
        SceneryAdapter sceneryAdapter = new SceneryAdapter(getContext(), shanghaiScenery);
        sceneryListview.setAdapter(sceneryAdapter);
        sceneryListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Scenery scenery = shanghaiScenery.get(i);
                Intent intent = new Intent(getActivity(), SceneryActivity.class);
                intent.putExtra("scenery", scenery);
                startActivity(intent);
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
