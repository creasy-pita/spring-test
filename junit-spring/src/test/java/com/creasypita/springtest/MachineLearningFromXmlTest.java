package com.creasypita.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;


import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by creasypita on 8/26/2020.
 *
 * @ProjectName: spring-test
 */
@RunWith(SpringJUnit4ClassRunner.class)
// if not add locations,spring will load classpath:/com/creasypita/springtest/MachineLearningFromXmlTest-context.xml
//if not add loader,spring will use GenericXmlContextLoader
@ContextConfiguration(locations = {
        "/spring-config.xml"},loader = GenericXmlContextLoader.class)
public class MachineLearningFromXmlTest {

    //DI
    @Autowired
//    @Qualifier("ml")
    DataModelService dataModelService;

    @Test
    public void test_ml_always_return_true() {
        //assert correct type/impl
        assertThat(dataModelService, instanceOf(MachineLearningService.class));

        //assert true
        assertThat(dataModelService.isValid(""), is(true));

    }
}
