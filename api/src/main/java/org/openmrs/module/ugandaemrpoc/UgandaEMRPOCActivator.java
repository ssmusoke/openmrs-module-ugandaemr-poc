/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ugandaemrpoc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.aijar.activator.HtmlFormsInitializer;
import org.openmrs.module.aijar.activator.Initializer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class UgandaEMRPOCActivator extends BaseModuleActivator {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * @see #started()
	 */
	public void started() {
		try {
			// run the initializers
			log.info("Running initializers for UgandaEMR POC");
			for (Initializer initializer : getInitializers()) {
				initializer.started();
			}
			log.info("Running initializers for  UgandaEMR POC completed");
			
			log.info("Started UgandaEMR POC");
		}
		catch (Exception e) {
			Module mod = ModuleFactory.getModuleById(UgandaEMRPOCConfig.MODULE_ID);
			ModuleFactory.stopModule(mod);
			throw new RuntimeException("failed to setup the module ", e);
		}
	}
	
	/**
	 * @see #shutdown()
	 */
	public void shutdown() {
		log.info("Shutdown UgandaEMR POC");
	}
	
	private List<Initializer> getInitializers() {
		List<Initializer> l = new ArrayList<Initializer>();
		// TODO: Enable this when there are HTML forms ot be loaded
		// l.add(new HtmlFormsInitializer(UgandaEMRPOCConfig.MODULE_ID));
		return l;
	}
	
}
