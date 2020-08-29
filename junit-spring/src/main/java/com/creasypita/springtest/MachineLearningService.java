package com.creasypita.springtest;

import org.springframework.stereotype.Service;

/**
 * Created by creasypita on 8/26/2020.
 *
 * @ProjectName: spring-test
 */
@Service("ml")
public class MachineLearningService implements DataModelService {

    public boolean isValid(String input) {
        return true;
    }

}
