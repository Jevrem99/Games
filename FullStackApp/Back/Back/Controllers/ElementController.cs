using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Linq.Expressions;

namespace Back.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ElementController : ControllerBase
    {
        [HttpGet]
        public async Task<ActionResult<List<Element>>> GetElements()
        {
            return new List<Element> { new Element
                {
                    AtomicNumber = 1,
                    Symbol = "H",
                    Name = "Hydrogen",
                    atomicMass = 1.00797
                } 
            };
        }
    }
}
