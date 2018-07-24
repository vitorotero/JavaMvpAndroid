package br.com.tecapp.mvparchitecture.base;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

import br.com.tecapp.mvparchitecture.shared.schedulers.SchedulerProvider;
import br.com.tecapp.mvparchitecture.shared.schedulers.SchedulerProviderImp;
import io.reactivex.schedulers.TestScheduler;

/**
 * @author Vitor Otero on 12/06/18.
 */
public abstract class BaseTest {

    protected TestScheduler testScheduler;
    protected ExceptionTest exception;
    protected SchedulerProvider testSchedulerProvider;
    protected String GENERIC_STRING = "Test";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        testScheduler = new TestScheduler();

        exception = new ExceptionTest();
        testSchedulerProvider = new SchedulerProviderImp();

        setupTest();
    }

    protected abstract void setupTest();

}
