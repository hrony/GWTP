/**
 * Copyright 2013 ArcBees Inc.
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

package com.gwtplatform.dispatch.rpc.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.dispatch.rpc.shared.Action;
import com.gwtplatform.dispatch.rpc.shared.Result;

/**
 * A factory used to create {@link com.gwtplatform.dispatch.client.DispatchCall} instances.
 * <p/>
 * You may want to create your own implementation where you will return your own
 * {@link com.gwtplatform.dispatch.client.DispatchCall DispatchCall} objects if you wish to make use of the extension
 * points available in {@link com.gwtplatform.dispatch.client.DispatchCall DispatchCall}.
 */
public interface RpcDispatchCallFactory {
    <A extends Action<R>, R extends Result> RpcDispatchExecuteCall<A, R> create(A action,
                                                                                AsyncCallback<R> callback);

    <A extends Action<R>, R extends Result> RpcDispatchUndoCall<A, R> create(A action,
                                                                             R result,
                                                                             AsyncCallback<Void> callback);
}
