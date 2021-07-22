package nz.co.spark.flowable.workflow.poc.action;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class HolidayRequestApproveAction implements JavaDelegate
{
    private static final Logger LOGGER = LogManager.getLogger(HolidayRequestApproveAction.class);

    @Override
    public void execute(final DelegateExecution execution)
    {
        LOGGER.info("Holiday request is approved. {}", execution.getId());
    }
}
