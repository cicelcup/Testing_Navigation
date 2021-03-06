package com.example.testing_navigation

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder

class DeepLinkAppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val remoteViews = RemoteViews(
            context.packageName,
            R.layout.widget
        )

        val pendingIntent = NavDeepLinkBuilder(context)
                .setGraph(R.navigation.navigation)
                .setDestination(R.id.imagesFragment)
                .createPendingIntent()

        remoteViews.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent)
            appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }
}