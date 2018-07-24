package br.com.tecapp.mvparchitecture.login;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import br.com.tecapp.mvparchitecture.base.BaseTest;
import br.com.tecapp.mvparchitecture.shared.manager.UserManager;
import br.com.tecapp.mvparchitecture.ui.login.LoginContract;
import br.com.tecapp.mvparchitecture.ui.login.LoginPresenter;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class LoginPresenterTest extends BaseTest {

    @Mock LoginContract.View view;
    @Mock UserManager manager;

    private LoginPresenter presenter;

    @BeforeClass
    public static void setUpRxSchedulers() {
        Scheduler immediate = new Scheduler() {
            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run);
            }
        };

        RxJavaPlugins.setInitIoSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitComputationSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitSingleSchedulerHandler(scheduler -> immediate);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> immediate);
    }

    @Override
    public void setupTest() {
        presenter = new LoginPresenter(view, exception, manager);
    }

    @After
    public void tearDown() throws Exception {
        presenter.detachView();
    }

    @Test
    public void shouldReturnSuccessWhenGetMoviesAndSuccess() {
//        List<MovieList> list = new ArrayList<>();
//        when(manager.getMovies())
//                .thenReturn(Single.just(list));
//
//        presenter.getMovies();
//        testScheduler.triggerActions();
//
//        verify(view).showLoading();
//        verify(view).fillList(list);
//        verify(view).hideLoading();
//        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldReturnSuccessWhenGetMoviesAndError() {
//        NullPointerException exception = new NullPointerException("teste");
//
//        when(manager.getMovies())
//                .thenReturn(Single.error(exception));
//
//        presenter.getMovies();
//        testScheduler.triggerActions();
//
//        verify(view).showLoading();
//        presenter.simpleError(exception);
//        verify(view).hideLoading();
//        verify(view, times(2))
//                .showGenericOneButton(Mockito.any(GenericButtonModal.class));
//        verifyNoMoreInteractions(view);
    }

}
