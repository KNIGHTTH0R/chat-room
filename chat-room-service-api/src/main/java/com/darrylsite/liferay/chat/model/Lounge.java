/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.darrylsite.liferay.chat.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Lounge service. Represents a row in the &quot;chatRoom_Lounge&quot; database table, with each column mapped to a property of this class.
 *
 * @author Darryl Kpizingui
 * @see LoungeModel
 * @see com.darrylsite.liferay.chat.model.impl.LoungeImpl
 * @see com.darrylsite.liferay.chat.model.impl.LoungeModelImpl
 * @generated
 */
@ImplementationClassName("com.darrylsite.liferay.chat.model.impl.LoungeImpl")
@ProviderType
public interface Lounge extends LoungeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.darrylsite.liferay.chat.model.impl.LoungeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Lounge, Long> ID_ACCESSOR = new Accessor<Lounge, Long>() {
			@Override
			public Long get(Lounge lounge) {
				return lounge.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Lounge> getTypeClass() {
				return Lounge.class;
			}
		};
}