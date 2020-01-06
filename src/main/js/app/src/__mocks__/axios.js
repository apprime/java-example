module.exports = {
  get: () => {
    return Promise.resolve({
        data: [{
          name: "TestBox",
          weight: 1,
          cost: 10,
          country: "Sweden",
          colour: {
            r: 255,
            g: 0,
            b: 0
          }
        }, {
          name: "TestBox2",
          weight: 2,
          cost: 20,
          country: "Sweden",
          colour: {
            r: 0,
            g: 255,
            b: 0
          }
        }]
    });
  },
  post: () => {
    return Promise.resolve({
        data: [
            {
                name: "ReturnBox"
            }
        ]
    });
  }
};