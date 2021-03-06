/*
 * Copyright 2015 ArcBees Inc.
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

package com.gwtplatform.dispatch.rest.processors.resource;

import java.util.ServiceLoader;

import com.gwtplatform.processors.tools.logger.Logger;
import com.gwtplatform.processors.tools.outputter.Outputter;
import com.gwtplatform.processors.tools.utils.Utils;

public class ResourcePostProcessors {
    private static ServiceLoader<ResourcePostProcessor> processors;
    private static boolean initialized;

    private final Logger logger;
    private final Utils utils;
    private final Outputter outputter;

    public ResourcePostProcessors(
            Logger logger,
            Utils utils,
            Outputter outputter) {
        this.logger = logger;
        this.utils = utils;
        this.outputter = outputter;

        if (processors == null) {
            processors = ServiceLoader.load(ResourcePostProcessor.class, getClass().getClassLoader());
        }
    }

    public void process(RootResource resource) {
        ensureInitialized();

        for (ResourcePostProcessor processor : processors) {
            processor.postProcess(resource);
        }
    }

    private void ensureInitialized() {
        if (!initialized) {
            for (ResourcePostProcessor processor : processors) {
                processor.init(logger, utils, outputter);
            }

            initialized = true;
        }
    }
}
