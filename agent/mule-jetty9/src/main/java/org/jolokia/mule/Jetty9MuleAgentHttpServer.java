package org.jolokia.mule;

/*
 * Copyright 2014 Michio Nakagawa
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.mule.api.agent.Agent;

/**
 * HTTP Server for the Mule agent which encapsulates a Eclipse Jetty server.
 *
 *
 * @author Bartłomiej Nićka
 * @since 10.10.14 (patched)
 */
public class Jetty9MuleAgentHttpServer extends BaseEclipseMuleAgentHttpServer {

    /**
     * Constructor
     *
     * @param pParent parent for creating proper exceptions
     * @param pConfig configuration of the server
     */
    Jetty9MuleAgentHttpServer(Agent pParent, MuleAgentConfig pConfig) {
        super( pParent, pConfig );
    }

    // Create a Jetty Server with the agent servlet installed
    protected Server getServer(MuleAgentConfig pConfig) {
        
        Server newServer = new Server();

        ServerConnector connector = new ServerConnector( newServer );
        if (pConfig.getHost() != null) {
            connector.setHost(pConfig.getHost());
        }
        connector.setPort(pConfig.getPort());

        newServer.addConnector( connector );
        return newServer;
    }
    
}
