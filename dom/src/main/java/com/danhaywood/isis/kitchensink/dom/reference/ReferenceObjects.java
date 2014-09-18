/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.danhaywood.isis.kitchensink.dom.reference;

import com.danhaywood.isis.kitchensink.dom.RepositoryAbstract;
import com.danhaywood.isis.kitchensink.dom.other.OtherBoundedObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherObject;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Reference Objects")
@DomainService(menuOrder = "10", repositoryFor = ReferenceObject.class)
public class ReferenceObjects extends RepositoryAbstract<ReferenceObject> {

    public ReferenceObjects() {
        super(ReferenceObject.class);
    }

    @MemberOrder(sequence = "30")
    public ReferenceObject create(
            final @Named("Name") String name,
            final @Named("Some Int") int i,
            final OtherObject otherObject,
            final OtherBoundedObject otherBoundedObject) {
        final ReferenceObject obj = container.newTransientInstance(ReferenceObject.class);
        obj.setName(name);

        obj.setSomeOtherObjectMandatoryWithChoices(otherObject);
        obj.setSomeOtherObjectActionOnlyWithChoices(otherObject);
        obj.setSomeOtherBoundedObjectMandatory(otherBoundedObject);

        container.persistIfNotAlready(obj);
        return obj;
    }

}