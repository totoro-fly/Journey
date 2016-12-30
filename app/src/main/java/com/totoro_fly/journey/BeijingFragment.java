package com.totoro_fly.journey;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BeijingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeijingFragment extends Fragment {


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

    public BeijingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BeijingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BeijingFragment newInstance(String param1, String param2) {
        BeijingFragment fragment = new BeijingFragment();
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
        ArrayList<Scenery> beijingScenery=new ArrayList<Scenery>();
        beijingScenery.add(new Scenery(R.drawable.changcheng,"长城","长城（万里长城），是古代中国为抵御不同时期塞北游牧部落联盟的侵袭，修筑规模浩大的军事工程的统称。长城东西绵延上万华里，因此又称作万里长城。现存的长城遗迹主要为始建于14世纪的明长城，西起嘉峪关，东至虎山长城，长城遗址跨越北京、天津、青海、山西、内蒙等15个省市自治区，总计有43721处长城遗产，长城也是自人类文明以来最巨大的单一建筑物。  2009年4月，中国国家测绘局及国家文物局报告最新的完整考古研究显示，明长城全长8851.8千米，其中人工墙体的长度为6259.6千米，壕堑长度为359.7千米，天然险的长度为2232.5千米，墙体平均高6至7米，宽4至5米。[1]  2012年6月5日，国家文物局宣布，历经近5年的调查和认定，中国历代长城总长度为21800千米。这是中国首次科学、系统地测量历代长城的总长度。"));
        beijingScenery.add(new Scenery(R.drawable.tiantan,"天坛","北京天坛位于北京市东城区，是明清两朝帝王祭天、祈谷和祈雨的场所。是现存中国古代规模最大、伦理等级最高的祭祀建筑群。1961年，天坛被中华人民共和国国务院公布为第一批全国重点文物保护单位之一。1998年，“北京皇家祭坛—天坛”被列为世界文化遗产。"));
        beijingScenery.add(new Scenery(R.drawable.yihuyuan,"颐和园","颐和园是清朝的皇家行宫和大型皇家园林，位于中国北京市海淀区西北，占地290公顷（合4400亩）。颐和园修建于清朝乾隆年间（原名清漪园）、重建于光绪年间，曾属于清朝北京西郊三山五园之一。颐和园素以人工建筑与自然山水巧妙结合的造园手法著称于世，是中国园林艺术顶峰时期的代表。[1][2]1998年，颐和园被评为世界文化遗产。"));
        beijingScenery.add(new Scenery(R.drawable.tiananmen,"天安门","天安门坐落在中国北京市中心，故宫的南端，与天安门广场隔长安街相望，是明清两代北京皇城的正门。设计者为明代的御用建筑匠师蒯祥。天安门始建与明朝永乐十五年（1417年），时称为承天门。清朝顺治八年（1651年）更名为天安门。1925年10月10日，国立故宫博物院成立，天安门始对民众开放。1949年10月1日，在这里举行了中华人民共和国的开国大典，它由此被设计入国徽，并成了中华人民共和国的象征之一。1961年，天安门被中华人民共和国国务院公布为第一批全国重点文物保护单位之一。"));
        SceneryAdapter sceneryAdapter=new SceneryAdapter(getContext(),beijingScenery);
        sceneryListview.setAdapter(sceneryAdapter);
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
