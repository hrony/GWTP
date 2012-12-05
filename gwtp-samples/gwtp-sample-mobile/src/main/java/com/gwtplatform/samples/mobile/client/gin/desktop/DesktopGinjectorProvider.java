/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.mobile.client.gin.desktop;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.gwtplatform.samples.mobile.client.gin.ClientGinjector;
import com.gwtplatform.samples.mobile.client.gin.GinjectorProvider;

public class DesktopGinjectorProvider implements GinjectorProvider {
    public final static Logger logger = Logger.getLogger(DesktopGinjectorProvider.class.getName());

    @Override
    public ClientGinjector get() {
        logger.info("DesktopGinjectorProvider get() DesktopGinjector was used.");

        return GWT.create(DesktopGinjector.class);
    }
}
