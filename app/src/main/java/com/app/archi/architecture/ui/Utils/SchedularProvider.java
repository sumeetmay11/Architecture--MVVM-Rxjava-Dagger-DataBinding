package com.app.archi.architecture.ui.Utils;

import io.reactivex.Scheduler;

public interface SchedularProvider {
     Scheduler getIo();
     Scheduler getUi();
     Scheduler getComputation();
}
