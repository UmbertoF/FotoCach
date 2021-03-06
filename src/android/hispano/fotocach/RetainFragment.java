package android.hispano.fotocach;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Un simple Fragment sin UI que guarda un Objeto simple y lo retiene por encima de los cambios de configuración.
 * Se utilizará para retener el objeto ImageCache.
 */
public class RetainFragment extends Fragment {
    private static final String TAG = "RetainFragment";
    private Object mObject;

    /**
     * Constructor vacío según la documentación de Fragment
     */
    public RetainFragment() {}

    /**
     * Localiza una instancia existente de este Fragment o si no la encuentra, 
     * crea y la añade usando FragmentManager.
     *
     * @param fragmentManager El FragmentManager que se utilizazá para el manejo.
     * @return La instancia existente del Fragment o la nueva instancia si fue creada.
     */
    public static RetainFragment findOrCreateRetainFragment(android.support.v4.app.FragmentManager fragmentManager) {
        // Comprueba si tenemos retenido el worker fragment.
        RetainFragment mRetainFragment = (RetainFragment) fragmentManager.findFragmentByTag(TAG);

        // Sin no está retenido (o es la primera en ejecutarse), necesitamos crearlo y añadirlo.
        if (mRetainFragment == null) {
            mRetainFragment = new RetainFragment();
            fragmentManager.beginTransaction().add(mRetainFragment, TAG).commit();
        }
        return mRetainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Asegura que este Fragment es retenido sobre los cambios de configuración.
        setRetainInstance(true);
    }

    /**
     * Almacena un objeto simple en este Fragment.
     *
     * @param object El objeto a almacenar
     */
    public void setObject(Object object) {
        mObject = object;
    }

    /**
     * Obtiene el objeto almacenado.
     *
     * @return El objeto almacenado
     */
    public Object getObject() {
        return mObject;
    }

}
