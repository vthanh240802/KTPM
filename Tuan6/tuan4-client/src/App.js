import "./App.css";
import Axios from "axios";
import { useEffect, useState } from "react";

function App() {
  const [products, setProducts] = useState([]);
  const headerTitle = ["ID", "Name", "Description", "price", "quantity"];
  const [user, setUser] = useState({
    email: "justinduy81@gmail.com",
    customerName: "Zian",
    address: "Ben Tre",
  });

  const [selectedProduct, setSelectedProduct] = useState({});

  const getProducts = async () => {
    const response = await Axios.get("http://localhost:8081/product");
    // console.log(response);
    let data = await response.data;
    data = data.map((item) => {
      return {
        ...item,
        quantity: 0,
      };
    });
    setProducts(data);
  };

  useEffect(() => {
    getProducts();
  }, []);

  return (
    <div className="App w-full flex">
      <div className="w-[60%]">
        <table className="w-full h-60 table-auto overflow-hidden border border-l-gray-500">
          <thead>
            <tr>
              {headerTitle.map((item, index) => {
                return (
                  <th key={index} className="p-4 border-b">
                    {item}
                  </th>
                );
              })}
            </tr>
          </thead>
          <tbody>
            {products.map((item, index) => {
              return (
                <tr key={index} className="even:bg-blue-100 even:rounded-md">
                  <td className="items-center text-center">{item.id}</td>
                  <td>{item.name}</td>
                  <td>{item.description}</td>
                  <td>{item.price}</td>
                  <td>
                    <input
                      type="text"
                      value={item.quantity}
                      onInput={(e) => {
                        const data = products.map((newItem) => {
                          if (item.id === newItem.id) {
                            return {
                              ...newItem,
                              quantity: Number(e.target.value),
                            };
                          } else {
                            return newItem;
                          }
                        });
                        setProducts(data);
                      }}
                    />
                  </td>

                  <td className="flex gap-2 p-3">
                    <button
                      className="px-4 py-2 bg-blue-700 text-white rounded-lg"
                      onClick={() => {
                        const data = {
                          ...user,
                          productId: item.id,
                          quantity: item.quantity,
                        };
                        const encoded = btoa(JSON.stringify(data));

                        Axios.post("http://localhost:8081/order", encoded);
                        alert(
                          "Đơn hàng đang được xử lý. Vui lòng kiểm tra email"
                        );
                      }}
                    >
                      Buy
                    </button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
      <div className="w-[30%]">
        <h2 className="text-xl mb-4 font-bold">Thông tin khách hàng</h2>
        <div className="w-full">
          Email :
          <input
            type="text"
            name="email"
            className="border p-2"
            value={user.email}
            onChange={(e) => {
              setUser({ ...user, [e.target.name]: e.target.value });
            }}
          />
        </div>
        <div className="w-full">
          Name :
          <input
            type="text"
            name="customerName"
            className="border p-2"
            value={user.customerName}
            onChange={(e) => {
              setUser({ ...user, [e.target.name]: e.target.value });
            }}
          />
        </div>
        <div className="w-full">
          Address :
          <input
            type="text"
            name="address"
            className="border p-2"
            value={user.address}
            onChange={(e) => {
              setUser({ ...user, [e.target.name]: e.target.value });
            }}
          />
        </div>
      </div>
      .
    </div>
  );
}

export default App;
