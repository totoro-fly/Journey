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
 * Use the {@link ChongqingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChongqingFragment extends Fragment {
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

    public ChongqingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChongqingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChongqingFragment newInstance(String param1, String param2) {
        ChongqingFragment fragment = new ChongqingFragment();
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
        ArrayList<Scenery> chongqingScenery = new ArrayList<Scenery>();
        chongqingScenery.add(new Scenery(R.drawable.sanxia, "三峡", "三峡位于中国重庆市和湖北省境内的长江干流上，西起重庆市奉节县的白帝城，东至湖北省宜昌市的南津关，全长193公里，由瞿塘峡、巫峡、西陵峡组成。长江三峡位于中国的腹地, 属亚热带季风气候区，跨重庆奉节、重庆巫山、湖北巴东、湖北秭归、湖北宜昌，也就是常说的“大三峡”。"));
        chongqingScenery.add(new Scenery(R.drawable.diaoyucheng, "钓鱼城","钓鱼城遗址位于重庆市合川区城区东面5公里的嘉陵江南岸钓鱼山上，因南宋与蒙古大军发生钓鱼城之战而闻名天下，蒙哥便在这里战死。这里是南宋四川置制司抗蒙山城之一。"));
        SceneryAdapter sceneryAdapter = new SceneryAdapter(getContext(), chongqingScenery);
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
