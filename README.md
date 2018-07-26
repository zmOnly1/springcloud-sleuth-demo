# springcloud-sleuth-demo

spring.factories


TraceAutoConfiguration
DefaultTracer

TraceWebAutoConfiguration
TraceFilter.createSpan
	recordParentSpan
		this.tracer.close
			this.spanReporter.report
			
this.tracer.addTag

TraceHttpServletResponse
	flushBuffer
		SsLogSetter.annotateWithServerSendIfLogIsNotAlreadyPresent
		
createSpan
	this.tracer.continueSpan
		this.spanLogger.logContinuedSpan
			MDC.put

log4jEventWrapper
	LogEvent
		getContextMap
		
TraceWebAutoConfiguration
	TraceWebMvcConfigurer
		TraceHandlerInterceptor.preHandle
			addClassMethodTag
			addClassNameTag
			
TraceWebClientAutoConfiguration
	TraceRestTemplateInterceptor
		response
			TraceHttpResponse
		intercept
			publishStartEvent
				createSpan
					continueSpan
						SpanContextHolder.setCurrentSpan
				this.spanInjector.inject
				addRequestTags
		response
			this.tracer.addTag
			finish->Span.CLIENT_RECV

SleuthHystrixAutoConfiguration
	SleuthHystrixConcurrencyStrategy
		wrapCallable
			HystrixTraceCallable
				call
					this.tracer.continueSpan

TraceSchedulingAutoConfiguration
	TraceSchedulingAspect
		traceBackgroundThread
			this.tracer.addTag(Span.SPAN_LOCAL_COMPONENT_TAG_NAME, SCHEDULED_COMPONENT);
			this.tracer.close(span);
