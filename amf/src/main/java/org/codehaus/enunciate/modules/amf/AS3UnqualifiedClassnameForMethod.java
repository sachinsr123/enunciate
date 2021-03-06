/*
 * Copyright 2006-2008 Web Cohesion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.enunciate.modules.amf;

import freemarker.template.TemplateModelException;

import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class AS3UnqualifiedClassnameForMethod extends AS3ClientClassnameForMethod {
  
  public AS3UnqualifiedClassnameForMethod(Map<String, String> conversions) {
    super(conversions);
  }

  @Override
  public String convertUnwrappedObject(Object unwrapped) throws TemplateModelException {
    String fqn = super.convertUnwrappedObject(unwrapped);
    int lastDot = fqn.lastIndexOf('.');
    if (lastDot < 0) {
      return fqn;
    }
    else {
      return fqn.substring(lastDot + 1);
    }
  }
}
