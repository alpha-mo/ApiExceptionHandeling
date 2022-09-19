# Spring boot REST API Exception Demo
______________
### About this Demo:
This Example allocates a simple Rest API that calls a fake service class.
The purpose of this demo is to handle some bad API calls from the frontend and let the backend respond accordingly.

## Exceptions handled in this demo:
- Custom Exception **ResourceNotFoundException**:
> can be used to throw an error when querying a resource in your DB.
___________
- MissingRequestHeaderException:
> Self-explanatory: used when an argument in the request header is missing.
__________
- MethodArgumentTypeMismatchException:
> Triggered when the argument in the request is in the wrong data-type.
_________
- NoHandlerFoundException
> Triggered when the exception has no exception-handler, in this demo it was implemented as a trigger for calling an API address that does not exist.
_________

### The Demo utilizes the `@ControllerAdvice` to handle the API Exceptions.
*Only Spring Web was used as a dependency.*