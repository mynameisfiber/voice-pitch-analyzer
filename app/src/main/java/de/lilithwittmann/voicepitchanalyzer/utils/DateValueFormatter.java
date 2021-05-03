package de.lilithwittmann.voicepitchanalyzer.utils;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.util.HashMap;

public class DateValueFormatter implements IAxisValueFormatter
{
    private final DateTime beginningDate;
    private final HashMap<Integer, String> formattedCache = new HashMap<>();

    public DateValueFormatter(DateTime beginningDate)
    {
        this.beginningDate = beginningDate;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis)
    {
        int days = (int) value;

        String cachedFormatted = this.formattedCache.get(days);
        if (cachedFormatted != null)
        {
            return cachedFormatted;
        }

        String formatted = DateFormat.getDateInstance().format(beginningDate.plusDays(days).toDate());
        this.formattedCache.put(days, formatted);
        return formatted;
    }
}
