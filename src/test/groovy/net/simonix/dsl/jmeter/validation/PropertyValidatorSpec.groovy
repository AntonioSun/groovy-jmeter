/*
 * Copyright 2020 Szymon Micyk
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
package net.simonix.dsl.jmeter.validation

import net.simonix.dsl.jmeter.model.PropertyDefinition
import spock.lang.Specification

class PropertyValidatorSpec extends Specification {

    static final Set<PropertyDefinition> TEST_PROPERTIES = [
            new PropertyDefinition(name: 'name', required: false),
            new PropertyDefinition(name: 'comments', required: false),
            new PropertyDefinition(name: 'enabled', required: true),
    ].toSet().asImmutable()

    def "All fields are correct"() {
        given: 'property validator with test properties'

        PropertyValidator validator = new PropertyValidator(TEST_PROPERTIES);

        when:
        ValidationResult result = validator.validate('test', null, [name: 'test', comments: 'comments', enabled: true])

        then:
        result == ValidationResult.success()
    }

    def "Not valid property"() {
        given: 'property validator with test properties'

        PropertyValidator validator = new PropertyValidator(TEST_PROPERTIES);

        when:
        ValidationResult result = validator.validate('test', null, [property: 'test'])

        then:
        result == ValidationResult.notValidProperties('test', [property: 'test'].collect { it.key } as Set<String>, TEST_PROPERTIES.collect {it.name } as Set<String>)
    }

    def "Required property missing"() {
        given: 'property validator with test properties'

        PropertyValidator validator = new PropertyValidator(TEST_PROPERTIES);

        when:
        ValidationResult result = validator.validate('test', null, [name: 'test', comments: 'comments'])

        then:
        result == ValidationResult.missingRequiredProperties('test', TEST_PROPERTIES.findAll { it.required }.collect { it.name } as Set<String>)
    }

    def "Required property missing where value is property"() {
        given: 'property validator with test properties'

        PropertyValidator validator = new PropertyValidator(TEST_PROPERTIES);
        validator.valueIsProperty = true

        when:
        ValidationResult result = validator.validate('test', 'value', [name: 'test', comments: 'comments'])

        then:
        result == ValidationResult.success()
    }
}
