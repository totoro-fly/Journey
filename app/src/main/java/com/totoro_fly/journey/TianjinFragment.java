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
 * Use the {@link TianjinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TianjinFragment extends Fragment {
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

    public TianjinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TianjinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TianjinFragment newInstance(String param1, String param2) {
        TianjinFragment fragment = new TianjinFragment();
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
        final ArrayList<Scenery> tianjinScenery = new ArrayList<Scenery>();
        tianjinScenery.add(new Scenery(R.drawable.jidihaiyangguan, "极地海洋馆", "天津极地海洋世界坐落于天津市滨海新区响螺湾商务区，是一个包括极地海洋馆、酒店式公寓、城市旅游大道、嘉年华板道街以及阳光海游城等五大板块的综合休闲旅游项目，整体投资约16亿元人民币，其中极地海洋馆2009年12月26日上午全国最大的极地海洋馆正式封顶，本项目已于2011年10月1日正式对外营业。"));
        tianjinScenery.add(new Scenery(R.drawable.tianjinzhiyan, "天津之眼", "天津之眼（英语：The Tianjin Eye）是一个位于中国天津海河永乐桥(原慈海桥)的巨型摩天轮。“天津之眼”是世界上唯一建在桥上的摩天轮。高120米，其直径达到110米，相当于35层楼高，轮外将装挂48个透明座舱，每个座舱的面积将达到12平方米左右，可供8个人同时乘坐，整个摩天轮可以同时实现384人观光。摩天轮依靠电力驱动，匀速旋转一周大约需要30分钟。位于最高处时，可以看到方圆40公里以内的景致。"));
        SceneryAdapter sceneryAdapter = new SceneryAdapter(getContext(), tianjinScenery);
        sceneryListview.setAdapter(sceneryAdapter);
        sceneryListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Scenery scenery = tianjinScenery.get(i);
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
