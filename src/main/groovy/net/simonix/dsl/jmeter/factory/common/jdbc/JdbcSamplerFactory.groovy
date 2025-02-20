/*
 * Copyright 2021 Szymon Micyk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.simonix.dsl.jmeter.factory.common.jdbc

import groovy.transform.CompileDynamic
import net.simonix.dsl.jmeter.factory.TestElementNodeFactory
import net.simonix.dsl.jmeter.model.definition.KeywordDefinition
import org.apache.jmeter.testelement.TestElement

/**
 * Base class for JDBC Sampler and Post/Pre processors.
 *
 * @see net.simonix.dsl.jmeter.factory.sampler.jdbc.JdbcRequestFactory
 * @see net.simonix.dsl.jmeter.factory.preprocessor.jdbc.JdbcPreprocessorFactory
 * @see net.simonix.dsl.jmeter.factory.postprocessor.jdbc.JdbcPostprocessorFactory
 */
@CompileDynamic
abstract class JdbcSamplerFactory extends TestElementNodeFactory {

    JdbcSamplerFactory(Class testElementClass, Class testElementGuiClass, KeywordDefinition definition) {
        super(testElementClass, testElementGuiClass, definition)
    }

    void updateTestElementProperties(TestElement testElement, Object name, Object value, Map config) {
        testElement.dataSource = config.use

        testElement.setProperty('dataSource', config.use as String)
    }
}
