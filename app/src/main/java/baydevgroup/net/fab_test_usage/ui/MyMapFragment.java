package baydevgroup.net.fab_test_usage.ui;

import com.google.android.gms.maps.SupportMapFragment;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/** Created by cingiz-mac on 18.04.17  */
public class MyMapFragment extends SupportMapFragment {

    /**
     *  Если бы мы работали с простым фрагментом из библиотеки поддержки
     *   то надо было бы переопределять как минимум onCreateView
     *   но у нас SupportMapFragment, который создает wrapper над MapView
     *   и сам создает все функции жизненного цикла
     */
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        View view = inflater.inflate(R.layout.mymapfragment, container,false);
//        //ViewUtils.initializeMargin(getActivity(), view);
//        return view;
//
//    }
}
