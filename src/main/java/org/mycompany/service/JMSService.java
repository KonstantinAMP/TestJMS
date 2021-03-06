package org.mycompany.service;

import org.mycompany.ejb.consumer.RegisterConsumerService;
import org.mycompany.ejb.producer.MessageProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by konstantinamp on 5/10/17.
 */
@Service
public class JMSService {

    private static final Logger LOG = LoggerFactory.getLogger(JMSService.class);

    private final MessageProducerService jmsTestProducer;
    private final RegisterConsumerService jmsTestConsumer;


    @Inject
    public JMSService(@Named(value = "registerConsumerService") RegisterConsumerService jmsTestConsumer,
                      @Named(value = "messageProducerService") MessageProducerService jmsTestProducer) {
        this.jmsTestProducer = jmsTestProducer;
        this.jmsTestConsumer = jmsTestConsumer;
    }

    /*
     * for synchronous handle queue message
     * you need to uncomment {jmsTestConsumer.registerConsumer();}
     * and remove JMSListener
     */
    public void testMethodService(String message) {
        LOG.debug("testMethodService has started");
        jmsTestProducer.produceMessage(message);
//        jmsTestConsumer.registerConsumer();
        LOG.debug("testMethodService has ended");
    }

}
