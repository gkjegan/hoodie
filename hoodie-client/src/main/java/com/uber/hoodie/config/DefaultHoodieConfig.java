/*
 * Copyright (c) 2016 Uber Technologies, Inc. (hoodie-dev-group@uber.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uber.hoodie.config;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

/**
 * Default Way to load Hoodie config through a java.util.Properties
 */
public class DefaultHoodieConfig implements Serializable {
    protected final Properties props;
    public DefaultHoodieConfig(Properties props) {
        this.props = props;
    }

    public Properties getProps() {
        return props;
    }

    public static void setDefaultOnCondition(Properties props, boolean condition, String propName,
        String defaultValue) {
        if (condition) {
            props.setProperty(propName, defaultValue);
        }
    }

    public static void setDefaultOnCondition(Properties props, boolean condition, DefaultHoodieConfig config) {
        if (condition) {
            props.putAll(config.getProps());
        }
    }

}