/*--------------------------------------------------------------------------*
 | Copyright (C) 2006 Christopher Kohlhaas                                  |
 |                                                                          |
 | This program is free software; you can redistribute it and/or modify     |
 | it under the terms of the GNU General Public License as published by the |
 | Free Software Foundation. A copy of the license has been included with   |
 | these distribution in the COPYING file, if not go to www.fsf.org         |
 |                                                                          |
 | As a special exception, you are granted the permissions to link this     |
 | program with every library, which license fulfills the Open Source       |
 | Definition as published by the Open Source Initiative (OSI).             |
 *--------------------------------------------------------------------------*/
package org.rapla.plugin.appointmentmarker;
import org.rapla.framework.Configuration;
import org.rapla.framework.Container;
import org.rapla.framework.PluginDescriptor;
import org.rapla.plugin.RaplaExtensionPoints;

public class AppointmentMarkerPlugin implements PluginDescriptor
{
    public static final String MARKER_ATTRIBUTE_KEY = "appointmentmarker";
    public String toString() {
        return "Appointment Marker";
    }

    public void provideServices(Container container, Configuration config) {
        container.addContainerProvidedComponent( RaplaExtensionPoints.PLUGIN_OPTION_PANEL_EXTENSION,AppointmentMarkerOption.class);
        
        if ( !config.getAttributeAsBoolean("enabled", false) )
        	return;

        container.addContainerProvidedComponent( RaplaExtensionPoints.OBJECT_MENU_EXTENSION, AppointmentMarkerMenuFactory.class, config);
        container.addContainerProvidedComponent( AppointmentMarker.class, AppointmentMarker.class, config);
    }

    public Object getPluginMetaInfos( String key )
    {
        return null;
    }

}

