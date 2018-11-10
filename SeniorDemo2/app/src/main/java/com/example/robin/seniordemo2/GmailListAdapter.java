package com.example.robin.seniordemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GmailListAdapter  extends RecyclerView.Adapter<GmailListAdapter.myViewHolder> {

        private Context mContext;
        private String[] mTitleCursor;
        private String[] mSubCursor;
        private String[] mBodyCursor;
        private String[] mTimeCursor;


        public GmailListAdapter(Context context, String[] titleCursor, String[] subCursor, String[] bodyCursor, String[] timeCursor) {
            this.mContext = context;
            this.mTitleCursor = titleCursor;
            this.mSubCursor = subCursor;
            this.mBodyCursor = bodyCursor;
            this.mTimeCursor = timeCursor;
        }


        //note: grabs the rumors list layout
        @Override
        public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.mail_llist_item, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(myViewHolder holder, final int position) {
            holder.titleTextView.setText(mTitleCursor[position]);
            holder.subTextView.setText(mSubCursor[position]);
            holder.bodyTextView.setText(mBodyCursor[position]);
            holder.timeTextView.setText(mTimeCursor[position]);

        }


        // returns the number of items in the rumors recycler view
        @Override
        public int getItemCount() {
            return mTimeCursor.length;
        }


        /**
         * Inner class to hold the views needed to display a single item in the recycler-view
         */
        class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView titleTextView;
            TextView subTextView;
            TextView bodyTextView;
            TextView timeTextView;
            Context context;


            /**
             * Constructor for our ViewHolder. Within this constructor, we get a reference to our
             * TextViews
             *
             * @param itemView The View that you inflated in
             *                {@link GmailListAdapter#onCreateViewHolder(ViewGroup, int)}
             */
            public myViewHolder(View itemView) {
                super(itemView);
                titleTextView = (TextView) itemView.findViewById(R.id.title);
                subTextView = (TextView) itemView.findViewById(R.id.header);
                bodyTextView = (TextView) itemView.findViewById(R.id.body);
                timeTextView = (TextView) itemView.findViewById(R.id.time);
            }

            @Override
            public void onClick(View v) {
                //Nothing!
                //This is where we'd put code if we wanted it to do something when we clicked on
                //the menu item, but I find it unlikely we'll want to.
                //This still needs to be here though to make the interface happy.
            }
        }
}
