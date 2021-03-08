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
package net.simonix.dsl.jmeter.factory.config

import net.simonix.dsl.jmeter.test.spec.TempFileSpec

import static net.simonix.dsl.jmeter.TestScriptRunner.configure
import static net.simonix.dsl.jmeter.TestScriptRunner.save

class HeadersFactorySpec extends TempFileSpec {

    def "Check headers generation"() {
        given: 'Test plan with header manager config element'
        def config = configure {
            plan {
                headers(name: 'Factory Headers', comments: "Factory Comment", enabled: false)
                headers {
                    header(name: 'header1', value: 'value1')
                    header(name: 'header2', value: 'value2')
                }
                headers values: [
                        header1: 'value1',
                        header2: 'value2'
                ]
            }
        }

        File resultFile = tempFolder.newFile('headers_0.jmx')

        when: 'save test to file'
        save(config, resultFile)

        then: 'both files matches'
        filesAreTheSame('headers_0.jmx', resultFile)
    }
}
