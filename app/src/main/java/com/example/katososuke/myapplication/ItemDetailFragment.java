package com.example.katososuke.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.katososuke.myapplication.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {

            String misakiFontName = "misaki.ttf";
            String retroFontName = "retro_computer.ttf";

            Typeface misakiFont = Typeface.createFromAsset( getActivity().getAssets(), misakiFontName );
            Typeface retroFont = Typeface.createFromAsset( getActivity().getAssets(), retroFontName );

            ((TextView) rootView.findViewById(R.id.info_name_text_view)).setText(mItem.content);
            ((TextView) rootView.findViewById(R.id.info_name_text_view)).setTypeface(retroFont);
//            ((TextView) rootView.findViewById(R.id.info_name_text_view)).setText("");
            ((TextView) rootView.findViewById(R.id.info_hobby_text_view)).setText("vim");
            ((TextView) rootView.findViewById(R.id.info_hobby_text_view)).setTypeface(retroFont);
//            ((TextView) rootView.findViewById(R.id.info_facebook_text_view)).setText("facebook");
//            ((TextView) rootView.findViewById(R.id.info_facebook_text_view)).setTypeface(retroFont);

            ((TextView) rootView.findViewById(R.id.info_story_text_view)).setTypeface(misakiFont);
            ((TextView) rootView.findViewById(R.id.info_story_text_view)).setLineSpacing((float)0.0, (float)1.5);

        }

        return rootView;
    }
}
