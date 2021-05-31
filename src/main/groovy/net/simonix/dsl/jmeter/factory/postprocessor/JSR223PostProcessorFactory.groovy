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
package net.simonix.dsl.jmeter.factory.postprocessor

import groovy.transform.CompileDynamic
import net.simonix.dsl.jmeter.factory.AbstractJSR223Factory
import net.simonix.dsl.jmeter.model.definition.DslDefinition
import org.apache.jmeter.extractor.JSR223PostProcessor
import org.apache.jmeter.testbeans.gui.TestBeanGUI

/**
 * The factory class responsible for building <code>jsrpostprocessor</code> element in the test.
 *
 * More details about the parameters are available at <a href="https://jmeter.apache.org/usermanual/component_reference.html#JSR223_Postprocessor">JSR223 Postprocessor</a>
 *
 * @see net.simonix.dsl.jmeter.factory.TestElementNodeFactory TestElementNodeFactory
 * @see AbstractJSR223Factory AbstractJSR223Factory
 */
@CompileDynamic
final class JSR223PostProcessorFactory extends AbstractJSR223Factory {

    JSR223PostProcessorFactory() {
        super(DslDefinition.JSR223_POSTPROCESSOR.title, JSR223PostProcessor, TestBeanGUI, DslDefinition.JSR223_POSTPROCESSOR.leaf, DslDefinition.JSR223_POSTPROCESSOR)
    }
}
