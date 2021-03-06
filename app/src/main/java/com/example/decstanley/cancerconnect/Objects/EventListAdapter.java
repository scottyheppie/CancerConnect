package com.example.decstanley.cancerconnect.Objects;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.decstanley.cancerconnect.R;

import java.util.List;


public class EventListAdapter extends
        RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView titleTextView;
        public TextView addressTextView;
        public TextView dateTextView;
        public TextView summaryTextView;



        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.title_textview);
            addressTextView = (TextView) itemView.findViewById(R.id.address_textview);
            dateTextView = (TextView) itemView.findViewById(R.id.date_textview);
            summaryTextView = (TextView) itemView.findViewById(R.id.summary_textview);

        }
    }


    // Store a member variable for the contacts
    private List<Event> mEvents;

    // Pass in the contact array into the constructor
    public EventListAdapter(List<Event> events) {
        mEvents = events;
    }
    // ... constructor and member variables

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View eventView = inflater.inflate(R.layout.event_posts, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(eventView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EventListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Event event = mEvents.get(position);

        // Set item views based on your views and data model
        TextView titleTextView = viewHolder.titleTextView;
        titleTextView.setText(event.getTitle());


        TextView addressTextView = viewHolder.addressTextView;
        addressTextView.setText(event.getEventAddress() + ", " + event.getTown() + ", " + event.getCounty() + ", " + event.getPostcode());

        TextView dateTextView = viewHolder.dateTextView;
        dateTextView.setText(event.getStartDateTime() + " " + event.getStartTime());

        TextView summaryTextView = viewHolder.summaryTextView;
        summaryTextView.setText(event.getEventSummary());


}

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mEvents.size();
    }
}

