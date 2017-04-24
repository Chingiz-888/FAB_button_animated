package baydevgroup.net.fab_test_usage.ui;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import baydevgroup.net.fab_test_usage.R;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        /**
         *  Вот здесь ключевое, что мы получаем инстанс не просто android.support.v4.app.Fragment
         *  а com.google.android.gms.maps.SupportMapFragment
         *  потому и кастим, когда отыскиваем по id
         *
         *  внизу же, кастинг не нужен, так как у нас класс MyMapFragment
         *  и так extend'иться от SupportMapFragment
         */


        /**
         *   Тут еще важный факт - мы могли бы использовать разметку фрагмента - файл
         *   mymapfragment.xml, но  в нашем случае в файое MyMapFragment.java
         *   пусто и мы просто впихиваем карту в контейнер, опрелеленный в разметке
         *   activity_main.xml
         */
        SupportMapFragment fragment = (SupportMapFragment) fm.findFragmentById(R.id.fragmentContainer);

        if(fragment == null) {
            fragment =  new MyMapFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();

            /**
             *  Google обязывает юзать именно асинхронный вызов карты
             *   "A GoogleMap must be acquired using getMapAsync(OnMapReadyCallback)."
             *   ссылка: https://developers.google.com/android/reference/com/google/android/gms/maps/MapFragment
             *
             *   Чтобы наша активити стала слушателем callback слушателем этого вызова
             *   нужно заимплементить OnMapReadyCallback и библиотеку
             *   import com.google.android.gms.maps.OnMapReadyCallback
             */
            fragment.getMapAsync(this);

            setupFAB();
        }
    }

    private void setupFAB() {
        //=============FAB ACTION BUTTON=====================
        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        // ВОТ ЭТА КНОПКА ДОБАВЛЯЕТСЯ ИЗ КОДА!!! ЕЕ НЕТ В РАЗМЕТКЕ!!
        FloatingActionButton action = new FloatingActionButton(MainActivity.this); //getBaseContext()
        action.setTitle("Добавить новый объект");
        action.setColorNormal(  Color.rgb(0, 255,   0) );
        action.setColorPressed( Color.rgb(0,   0, 255) );
        action.setIconDrawable( ResourcesCompat.getDrawable(getResources(), R.drawable.adding_house_icon, null)  );
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        // ВОТ ЭТА КНОПКА ДОБАВЛЯЕТСЯ ИЗ КОДА!!! ЕЕ НЕТ В РАЗМЕТКЕ!!
        menuMultipleActions.addButton(action);
        //===================================================
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(52, 34)).title("Marker"));
    }

}
