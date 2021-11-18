package interfaces;

import enumerations.ReportLevel;

public interface Layout {
    String format(String time, String message, ReportLevel reportLevel);
}
