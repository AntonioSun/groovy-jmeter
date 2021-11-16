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
package net.simonix.dsl.jmeter.factory.sampler.http

import groovy.transform.CompileDynamic
import net.simonix.dsl.jmeter.factory.TestElementFactory
import net.simonix.dsl.jmeter.factory.common.FileFactory
import net.simonix.dsl.jmeter.model.definition.DslDefinition

/**
 * Builds the single file for test element. It is used with conjunction with <code>ajp</code> elements.
 *
 * <pre>
 * // structure of the file
 * file (
 *     file: string
 *     name: string
 *     type: string
 * )
 * // example usage
 * start {
 *     plan {
 *         ajp {
 *             files {
 *                 file 'test1.txt', name: 'param1', type: 'text/plain'
 *                 file 'test2.txt', name: 'param2', type: 'text/plain'
 *             }
 *         }
 *     }
 * }
 * </pre>
 *
 * @see TestElementFactory TestElementFactory
 * @see net.simonix.dsl.jmeter.factory.sampler.AjpFactory AjpFactory
 * @see net.simonix.dsl.jmeter.factory.sampler.http.AjpFilesFactory AjpFilesFactory
 * @see net.simonix.dsl.jmeter.factory.common.FilesFactory FilesFactory
 */
@CompileDynamic
final class AjpFileFactory extends FileFactory {

    AjpFileFactory() {
        super(DslDefinition.AJP_FILE)
    }
}
