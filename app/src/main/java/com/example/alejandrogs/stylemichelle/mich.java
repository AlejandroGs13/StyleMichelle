package com.example.alejandrogs.stylemichelle;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.RemoteViews;

import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class mich extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mich);

        Intent intent = new Intent(context,mich.class);
        intent.setAction("ACTUALIZAR");
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,0);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.b1,pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    static void updateAppWidget2(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mich);

        Intent intent = new Intent(context,mich.class);
        intent.setAction("LOGIN");
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,0);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.b2,pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
            updateAppWidget2(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals("ACTUALIZAR")){
            Intent Nota =new Intent(context,Main2Activity.class);
            Nota.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Nota.setData(Uri.parse(Nota.toUri(Intent.URI_INTENT_SCHEME)));
            context.startActivity(Nota);
        }
        if (intent.getAction().equals("LOGIN")){
            Intent Nota =new Intent(context,MainActivity.class);
            Nota.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Nota.setData(Uri.parse(Nota.toUri(Intent.URI_INTENT_SCHEME)));
            context.startActivity(Nota);
        }
    }
}

