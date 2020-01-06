import React, { useState } from 'react';

export default function CountryOptions() {
   const [countries] = useState(["Sweden", "China", "Brazil", "Australia"]);

   //useEffect(() => fetchCountries from DB, not implemented

   return countries.map((names, key) =>
              <option
                  key={ key }
                  value={ names }
              >
              { names }
              </option>
      )
}