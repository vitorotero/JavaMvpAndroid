package br.com.tecapp.mvparchitecture.shared.schedulers;

import io.reactivex.Scheduler;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface SchedulerProvider {

    Scheduler io();

    Scheduler ui();

    Scheduler computation();

}
