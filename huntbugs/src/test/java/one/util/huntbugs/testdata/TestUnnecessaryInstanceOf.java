/*
 * Copyright 2016 HuntBugs contributors
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
package one.util.huntbugs.testdata;

import one.util.huntbugs.registry.anno.AssertNoWarning;
import one.util.huntbugs.registry.anno.AssertWarning;

/**
 * @author Tagir Valeev
 *
 */
public class TestUnnecessaryInstanceOf {
    @AssertWarning("UnnecessaryInstanceOfInferred")
    void testInferred(int x) {
        Object a = 1.0;
        if(x > 2) a = -2;
        if(a instanceof Number) {
            System.out.println(a);
        }
    }

    @SuppressWarnings("cast")
    @AssertWarning("UnnecessaryInstanceOf")
    void testSimple() {
		String a = "test";
		if (a instanceof CharSequence) {
			System.out.println(a);
		}
    }
    
    @AssertNoWarning("*")
    void testArray(String[] data) {
        Object[] arr = data;
        if(arr instanceof Integer[]) {
            System.out.println("Never");
        }
    }
    
    @AssertWarning("UnnecessaryInstanceOf")
    void testArrayOk(String[] data) {
        Object[] arr = data;
        if(arr instanceof CharSequence[]) {
            System.out.println("Always");
        }
    }
}
