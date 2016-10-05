package io.advantageous.qbit.service.discovery;

import io.advantageous.reakt.promise.Promise;

import java.util.List;

public interface ServiceDiscoveryClient {


    /**
     * Register the service with the service discovery service if applicable.
     *
     * @param serviceName serviceName
     * @param host        host
     * @param port        port
     * @return EndpointDefinition
     */
    Promise<EndpointDefinition> register(
            final String serviceName,
            final String host,
            final int port);

    /**
     * Register with the service discovery system and specify a TTL so that if
     * the service does not send a checkIn that it is marked down.
     * TTL is time to live.
     *
     * @param serviceName       service name
     * @param host              host
     * @param port              port
     * @param timeToLiveSeconds ttl
     * @return EndpointDefinition
     */
    Promise<EndpointDefinition> registerWithTTL(
            final String serviceName,
            final String host,
            final int port,
            final int timeToLiveSeconds);

    /**
     * Register an end point given an id, and a TTL.
     * This gets used if you want to be specific about what you call the service.
     *
     * @param serviceName       service name
     * @param serviceId         service id
     * @param host              host
     * @param port              port
     * @param timeToLiveSeconds ttl
     * @return EndpointDefinition
     */
    Promise<EndpointDefinition> registerWithIdAndTimeToLive(
            final String serviceName, final String serviceId, String host, final int port, final int timeToLiveSeconds);


    /**
     * Register with id. Specify a unique id that is not autogenerated
     *
     * @param serviceName service name
     * @param serviceId   service id
     * @param host        host
     * @param port        port
     * @return EndpointDefinition
     */
     Promise<EndpointDefinition> registerWithId(final String serviceName, final String serviceId, String host, final int port) ;

    /**
     * Register an end point given an id, and a TTL with tags.
     * This gets used if you want to be specific about what you call the service.
     *
     * @param serviceName       service name
     * @param serviceId         service id
     * @param host              host
     * @param port              port
     * @param timeToLiveSeconds ttl
     * @param endpointTags      endpointTags
     * @return EndpointDefinition
     */
    Promise<EndpointDefinition> registerWithIdAndTTLAndTags(String serviceName, String serviceId, String host, int port, int timeToLiveSeconds,
                                                           List<String> endpointTags);



    /**
     * Loads services async.
     *
     * @param serviceName name of service
     */
    Promise<List<EndpointDefinition>> loadServicesAsync( final String serviceName);

}